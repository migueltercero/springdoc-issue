package test.org.springdoc.api.app21;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RepositoryRestResource(collectionResourceRel = "people", path = "peopleme")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	
	@Operation(summary = "find by id")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "successful operation"),
					@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
					@ApiResponse(responseCode = "404", description = "Contact not found"),
					@ApiResponse(responseCode = "405", description = "Validation exception") }
	)
	@RestResource
	Optional<Person> findById(Long id);

	@Operation(description = "this is my test")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200", description = "successful operation"),
					@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
					@ApiResponse(responseCode = "404", description = "Contact not found"),
					@ApiResponse(responseCode = "405", description = "Validation exception") }
	)
	List<Person> findByLastName(@Param("lastName") String name);

	@Operation(description = "this is another test", responses = {
			@ApiResponse(responseCode = "200", description = "another successful operation"),
			@ApiResponse(responseCode = "404", description = "another Contact not found") }
	)
	List<Person> findByFirstName(@Param("firstName")  @Parameter(description = "this is for first Name") String name);

}